package myApp;

import java.util.ArrayList;
import java.util.List;

public class Recipe {
    private String recipeName; 
    private String details;
    private String instructions;
    private  List<Feedback> feedbackList = new ArrayList<Feedback>();
    private User sharedBy;
    private String category;

    public Recipe(String recipeName, String details, String instructions, User sharedBy) {
        if (recipeName == null || recipeName.isEmpty()) {
            throw new IllegalArgumentException("Recipe name cannot be null or empty");
        }
        this.recipeName = recipeName;
        this.details = details;
        this.instructions = instructions;
        this.sharedBy = sharedBy;
    }

    public Recipe() {
		// TODO Auto-generated constructor stub
	}

	public String getRecipeName() {
        return recipeName;
    }

    public void setRecipeName(String recipeName) {
        if (recipeName == null || recipeName.isEmpty()) {
            throw new IllegalArgumentException("Recipe name cannot be null or empty");
        }
        this.recipeName = recipeName;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public User getSharedBy() {
        return sharedBy;
    }

    public void setSharedBy(User sharedBy) {
        this.sharedBy = sharedBy;
    }

   
    public  List<Feedback> getFeedbackList() {
        return feedbackList;
    }
	public void setFeedbackList(List<Feedback> feedbackList) {
		this.feedbackList = feedbackList;
	}

	public void addFeedback(Feedback feedback) {
        if (feedback != null) {
            this.feedbackList.add(feedback);
        }
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Recipe [recipeName=" + recipeName + ", details=" + details + ", instructions=" + instructions
                + ", feedbackList=" + feedbackList + ", sharedBy=" + sharedBy.getUsername() + "]";
    }
}

