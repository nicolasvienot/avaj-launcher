public class addinttotab {
	public static int[] addInt(int [] series, int newInt)
	{
		int[] newSeries = new int[series.length + 1];
		for (int i = 0; i < series.length; i++)
		{
			newSeries[i] = series[i];
		}
		newSeries[newSeries.length - 1] = newInt;
		return(newSeries);
	}
}
