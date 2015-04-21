/**
 * ServerStart.java mockit 
 * 2015 下午3:29:55 
 */
package mockit.json;

import java.io.IOException;
import com.github.dreamhead.moco.HttpServer;
import org.apache.http.client.fluent.Content;
import org.apache.http.client.fluent.Request;
import com.github.dreamhead.moco.Runnable;
import static com.github.dreamhead.moco.Moco.*;
import static com.github.dreamhead.moco.Runner.*;

/**
 * @author chenguangjian 2015年4月21日 下午3:29:55
 */
public class ServerStart {

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		HttpServer server = httpserver(12306);
		server.response("foo");

		running(server, new Runnable() {
			public void run() throws IOException {
				Content content = Request.Get("http://localhost:12306")
						.execute().returnContent();
				System.out.println(content);
			}
		});
	}

}
