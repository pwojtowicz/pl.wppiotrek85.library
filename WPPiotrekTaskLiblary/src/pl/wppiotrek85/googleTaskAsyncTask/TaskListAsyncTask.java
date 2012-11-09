package pl.wppiotrek85.googleTaskAsyncTask;

import java.io.IOException;

public class TaskListAsyncTask extends BaseGoogleTaskAsyncTask {

	public TaskListAsyncTask(String token, IOnTaskResponse listener,
			TaskMethods method) {
		super(token, listener, method);
	}

	@Override
	protected Void doInBackground(String... params) {
		try {
			Thread.sleep(6000);
			switch (method) {
			case GetObjectsList:
				getTaskList(params);
				break;

			default:
				break;
			}
		} catch (IOException e) {
			responseObject = e;
		} catch (InterruptedException e) {
			responseObject = e;
		} finally {

		}
		return null;
	}

	public void getTaskList(String... params) throws IOException {
		String fields = "items(id,title,updated)";
		if (params.length > 0) {
			fields = params[0];
		}
		com.google.api.services.tasks.Tasks.Tasklists.List list = service
				.tasklists().list();
		list.setFields(fields);
		responseObject = list.execute().getItems();
	}

}
