/**
 * 
 */
package kisti.edison.cloud.manager;

/**
 * @author root
 * 
 */
public class Command<T> {
	private String type;
	private T data;

	public Command(String type, T data) {
		this.setType(type);
		this.setData(data);
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
}
