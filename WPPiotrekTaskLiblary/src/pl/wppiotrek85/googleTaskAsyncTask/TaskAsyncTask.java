package pl.wppiotrek85.googleTaskAsyncTask;

import java.io.IOException;

public class TaskAsyncTask extends BaseGoogleTaskAsyncTask {

	public TaskAsyncTask(String token, IOnTaskResponse listener,
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
		} catch (InterruptedException e) {
			responseObject = e;
		} catch (IOException e) {
			e.printStackTrace();
		} finally {

		}
		return null;
	}

	private void getTaskList(String[] params) throws IOException {
		String fields = "items(completed,id,parent,status,title)";
		String taskListId = "MDI5MjIxMzQ1Njk4OTcwMzQ1NTA6MTQ3NDkwOTMyMjow";
		if (params.length > 0) {
			taskListId = params[0];
		}

		com.google.api.services.tasks.Tasks.TasksOperations.List listRequest = service
				.tasks().list(taskListId);
		listRequest.setFields(fields);
		responseObject = listRequest.execute().getItems();
	}

}
