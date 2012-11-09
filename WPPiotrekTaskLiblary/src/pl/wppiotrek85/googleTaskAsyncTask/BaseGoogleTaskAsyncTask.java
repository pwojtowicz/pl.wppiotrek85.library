package pl.wppiotrek85.googleTaskAsyncTask;

import android.os.AsyncTask;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.googleapis.services.GoogleKeyInitializer;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.gson.GsonFactory;

public abstract class BaseGoogleTaskAsyncTask extends
		AsyncTask<String, Void, Void> {

	final HttpTransport transport = AndroidHttp.newCompatibleTransport();

	final JsonFactory jsonFactory = new GsonFactory();

	GoogleCredential credential = new GoogleCredential();

	com.google.api.services.tasks.Tasks service;

	protected TaskMethods method;
	protected IOnTaskResponse listener;
	protected Object responseObject;

	public BaseGoogleTaskAsyncTask(String token, IOnTaskResponse listener,
			TaskMethods method) {
		this.listener = listener;
		service = new com.google.api.services.tasks.Tasks.Builder(transport,
				jsonFactory, credential)
				.setApplicationName("plwppiotrek85wydatki")
				.setJsonHttpRequestInitializer(
						new GoogleKeyInitializer(ClientCredentials.KEY))
				.build();
		credential.setAccessToken(token);
		this.method = method;
	}

	@Override
	protected void onPreExecute() {
		if (listener != null)
			listener.onTaskStart();
	}

	@Override
	protected void onPostExecute(Void result) {
		if (listener != null)
			listener.onTaskEnd(responseObject);
	}
}
