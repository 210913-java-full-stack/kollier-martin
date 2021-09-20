package DAOs;

public class ToDoItem {
    private String text = "";
    private boolean complete = false;
    int id = 0;

    public ToDoItem()
    {
        complete = false;
    }

    public ToDoItem(String item)
    {
        complete = false;
        this.text = item;
    }
    public String getToDoText()
    {
        return text;
    }

    public String getText() {
        return text;
    }

    public boolean isComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }

    public void setText(String text) {
        this.text = text;
    }
}
