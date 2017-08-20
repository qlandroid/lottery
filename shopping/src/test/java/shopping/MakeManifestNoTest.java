package shopping;

import org.ql.shopping.util.MakeManifestNo;

public class MakeManifestNoTest {
	public static void main(String[] args) {
		new Thread(new Runnable() {

			public void run() {
				System.out.println("创建日期 = " + Thread.currentThread().getName() + System.currentTimeMillis());
				String id = MakeManifestNo.getInstance().nextId();
				System.out.println("结束日期 = " + Thread.currentThread().getName() + System.currentTimeMillis());

			}
		}).start();

	}
}
