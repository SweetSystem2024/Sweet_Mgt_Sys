package myApp;

public class Feedback {

    private String content;
    private User user;
    private Recipe recipe;

    public Feedback(String content, User user, Recipe recipe) {
        this.content = content;
        this.user = user;
        this.recipe = recipe;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

	@Override
	public String toString() {
		return "Feedback [content=" + content + "]";
	}

  
}
