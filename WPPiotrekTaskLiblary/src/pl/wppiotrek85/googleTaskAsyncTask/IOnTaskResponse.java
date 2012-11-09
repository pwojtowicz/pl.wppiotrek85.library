package pl.wppiotrek85.googleTaskAsyncTask;


public interface IOnTaskResponse {

	public void onTaskStart();

	public void onTaskEnd(Object items);
}
