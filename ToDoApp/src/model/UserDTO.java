package model;

public class UserDTO {
	private int taskId;
	private String task;
	
	public UserDTO(int taskId, String task) {
		super();
		this.taskId = taskId;
		this.task = task;
	}

	public int getTaskId() {
		return taskId;
	}

	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}

	public String getTask() {
		return task;
	}

	public void setTask(String task) {
		this.task = task;
	}

}
