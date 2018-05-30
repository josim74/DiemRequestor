package com.biswajitbanik.Diem.Task.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Omar Faruq on 5/22/2018.
 */

public class QuestionDBHandler {


    public void getQuestions(QuestionDBCallback callback){
        List<QuestionModel> models = new ArrayList<>();

        QuestionModel model = new QuestionModel("Task Title:",
               "Please tell us briefly what you need done",
                "e.g. Dog sitter needer for 3 hours.",
                50,null, false);
        models.add(model);


        List<String> objectives=new ArrayList<>();
        objectives.add("Yes");
        objectives.add("No");
        objectives.add("This task does not need any equpment or material");

        model = new QuestionModel("Equipment:",
                "Would you be providing with equipment or material needed for this task?",
                null,
                0,objectives, false);
        models.add(model);


        objectives=new ArrayList<>();
        objectives.add("Immediately (ideally within 90 mins)");
        objectives.add("As soon as possible");
        objectives.add("On a specific date");
        objectives.add("On a Weekend");

        model = new QuestionModel("Preferred Date:",
                "When would you like to schedule this job?",
                null,
                0,objectives, false);
        models.add(model);


        objectives=new ArrayList<>();
        objectives.add("A specific Time");
        objectives.add("Early Morning (6 am to 9am)");
        objectives.add("Morning (9 am to 12 pm)");
        objectives.add("Afternoon (12 pm to 4 pm)");
        objectives.add("Evening (4 pm to 8 pm)");

        model = new QuestionModel("Preferred Time:",
                "When time would you like to schedule this job?",
                null,
                0,objectives, false);
        models.add(model);


        objectives = null;


        model = new QuestionModel("Pets Information:",
                "Do you have any pets on property that your jobber should be aware of?",
                null,
                0,objectives, true);
        models.add(model);

        model = new QuestionModel("Job Details:",
                "Please share any important notes about your job request for you jobber",
                "For example - Area of focus, any applicable measurements, additional requirements, etc",
                300,objectives, false);
        models.add(model);


        callback.getQuestion(models);




    }
}
