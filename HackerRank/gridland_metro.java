import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {
	/**
	 * HashMap "tracksPerRow".
	 * Keys: rows with tracks.
	 * Values: tracks contained in the respective rows.
	 */
	private static Map<Integer, ArrayList<Track>> tracksPerRow = new HashMap<Integer, ArrayList<Track>>();

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int numberOfRows = scanner.nextInt();
		int numberOfColumns = scanner.nextInt();
		int numberOfTracks = scanner.nextInt();

		for (int i = 0; i < numberOfTracks; i++) {
			int row = scanner.nextInt();
			int startColumn = scanner.nextInt();
			int endColumn = scanner.nextInt();
			fillMap(row, startColumn, endColumn);
		}
		scanner.close();

		sortTracksInsideRows_decreasingOrderOfStartColumn();
		long totalCellsWithTracks__exludingOverlaps = getTotalCellsWithTracks_exludingOverlaps();

		long spotsForLampPosts = (long) numberOfRows * numberOfColumns - (long) totalCellsWithTracks__exludingOverlaps;
		System.out.println(spotsForLampPosts);
	}

	/**
	 * Fills HashMap "tracksPerRow" with the respective information about rows and
	 * tracks.
	 */
	private static void fillMap(int row, int start, int end) {
		Track track = new Track(start, end);

		if (!tracksPerRow.containsKey(row)) {
			ArrayList<Track> tracks = new ArrayList<Track>();
			tracks.add(track);
			tracksPerRow.put(row, tracks);
		} else {
			tracksPerRow.get(row).add(track);
		}
	}

	/**
	 * Sorts each list of tracks within each row in decreasing order of the start
	 * columns.
	 */
	private static void sortTracksInsideRows_decreasingOrderOfStartColumn() {
		for (int row : tracksPerRow.keySet()) {
			Collections.sort(tracksPerRow.get(row));
		}
	}

	/**
	 * Checks for overlapping tracks within each row, and if there are any, merges
	 * them.
	 * 
	 * Calculates the total number of cells with tracks without overlaps.
	 *
	 * @return long value, representing the total number of cells with tracks,
	 *         excluding overlaps.
	 */
	private static long getTotalCellsWithTracks_exludingOverlaps() {

		long totalCellsWithTracks__exludingOverlaps = 0;

		for (int row : tracksPerRow.keySet()) {

			/**
			 * Index for total number of tracks within each row, excluding overlaps.
			 */
			int index = 0;
			/**
			 * If there are any overlapping tracks within a row, the original ArrayList
			 * "tracks" will be modified so that it contains only non-overlapping tracks, up
			 * to the point of the value of "index".
			 */
			ArrayList<Track> tracks = tracksPerRow.get(row);

			for (int i = 0; i < tracks.size(); i++) {

				/**
				 * If there is an overlap and this is not the first track in the list:
				 * 
				 * Merge the two tracks. Designate as start/end column the respective
				 * lower/higher value of the tracks being merged. Decrease the number of tracks
				 * without overlaps with one (the value of "index").
				 * 
				 * Continue going through the list backwards, until there are no more overlaps
				 * or the first track is reached.
				 */
				if (index != 0 && tracks.get(index - 1).startColumn <= tracks.get(i).endColumn) {
					while (index != 0 && tracks.get(index - 1).startColumn <= tracks.get(i).endColumn) {

						int minStart = Math.min(tracks.get(index - 1).startColumn, tracks.get(i).startColumn);
						int maxEnd = Math.max(tracks.get(index - 1).endColumn, tracks.get(i).endColumn);

						tracks.get(index - 1).startColumn = minStart;
						tracks.get(index - 1).endColumn = maxEnd;
						index--;
					}
				}
				/**
				 * If there is no overlap:
				 * 
				 * Sets the list at the current value of "index" with the current track.
				 */
				else {
					tracks.set(index, tracks.get(i));
				}
				index++;
			}

			/**
			 * Goes through the list of tracks of the current row, up to the point until
			 * there are only tracks without overlaps (the value of "index").
			 * 
			 * Calculates the total number of cells contained in these tracks.
			 */
			for (int j = 0; j < index; j++) {
				totalCellsWithTracks__exludingOverlaps += (long) tracks.get(j).endColumn
						- (long) tracks.get(j).startColumn + 1;
			}
		}
		return totalCellsWithTracks__exludingOverlaps;
	}

	/**
	 * A class that represents the tracks in the rows.
	 */
	private static class Track implements Comparable<Track> {

		int startColumn;
		int endColumn;

		public Track(int startColumn, int endColumn) {
			this.startColumn = startColumn;
			this.endColumn = endColumn;
		}

		/**
		 * Sort in decreasing order of start column.
		 */
		@Override
		public int compareTo(Track arg0) {
			return arg0.startColumn - this.startColumn;
		}
	}
}
