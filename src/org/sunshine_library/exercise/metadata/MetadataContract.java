package org.sunshine_library.exercise.metadata;

import android.net.Uri;
import android.provider.BaseColumns;

/**
 * Created with IntelliJ IDEA.
 * User: linuo
 * Date: 1/9/13
 */
public class MetadataContract {
    public static final String AUTHORITY = "org.sunshine_library.exercise.metadata.provider";

    public static final Uri AUTHORITY_URI = new Uri.Builder().scheme("content")
            .authority(AUTHORITY).build();

    public interface Columns extends BaseColumns {
        java.lang.String _IDENTIFIER = "identifier";
        java.lang.String _NAME = "name";
        java.lang.String _BODY = "body";
        java.lang.String _SEQUENCE = "seq";
        java.lang.String _USER_PROGRESS = "user_progress";
        java.lang.String _USER_RESULT = "user_result";
        java.lang.String _USER_DURATION = "user_duration";
    }

    public static final class Subjects {
        public static final String _IDENTIFIER = Columns._IDENTIFIER;
        public static final String _NAME = Columns._NAME;

        public static final Uri CONTENT_URI = AUTHORITY_URI.buildUpon().appendPath("subjects").build();
    }

    public static final class Lessons {
        public static final String _IDENTIFIER = Columns._IDENTIFIER;
        public static final String _PARENT_IDENTIFIER = "subject_identifier";
        public static final String _NAME = Columns._NAME;
        public static final String _TIME = "time";
        public static final String _USER_PROGRESS = Columns._USER_PROGRESS;
        public static final String _USER_PERCENTAGE = "user_percentage";
        public static final String _USER_RESULT = Columns._USER_RESULT;

        public static final Uri CONTENT_URI = AUTHORITY_URI.buildUpon().appendPath("lessons").build();
    }

    public static final class Stages {
        public static final String _IDENTIFIER = Columns._IDENTIFIER;
        public static final String _PARENT_IDENTIFIER = "lesson_identifier";
        public static final String _SEQUENCE = Columns._SEQUENCE;
        public static final String _TYPE = "stage_type";
        public static final String _NAME = Columns._NAME;
        public static final String _BODY = Columns._BODY;
        public static final String _USER_PROGRESS = Columns._USER_PROGRESS;

        public static final int TYPE_BASIC = 0;
        public static final int TYPE_EXTEND = 1;

        public static final Uri CONTENT_URI = AUTHORITY_URI.buildUpon().appendPath("subjects").build();
    }

    public static final class Sections {
        public static final String _IDENTIFIER = Columns._IDENTIFIER;
        public static final String _PARENT_IDENTIFIER = "stage_identifier";
        public static final String _SEQUENCE = Columns._SEQUENCE;
        public static final String _NAME = Columns._NAME;
        public static final String _USER_PROGRESS = Columns._USER_PROGRESS;

        public static final Uri CONTENT_URI = AUTHORITY_URI.buildUpon().appendPath("sections").build();
    }

    public static final class Activities {
        public static final String _IDENTIFIER = Columns._IDENTIFIER;
        public static final String _PARENT_IDENTIFIER = "section_identifier";
        public static final String _SEQUENCE = Columns._SEQUENCE;
        public static final String _TYPE = "activity_type";
        public static final String _NAME = Columns._NAME;
        public static final String _BODY = Columns._BODY;
        public static final String _WEIGHT = "weight";
        public static final String _JUMP_CONDITION = "jump_condition";
        // public static final String _REVIEW_TYPE = "review_type";
        public static final String _USER_PROGRESS = Columns._USER_PROGRESS;
        public static final String _USER_DURATION = Columns._USER_DURATION;
        public static final String _USER_RESULT = Columns._USER_RESULT;

        public static final Uri CONTENT_URI = AUTHORITY_URI.buildUpon().appendPath("activities").build();

        public static final int TYPE_NONE = -1;
        public static final int TYPE_TEXT = 0;
        public static final int TYPE_AUDIO = 1;
        public static final int TYPE_VIDEO = 2;
        public static final int TYPE_GALLERY = 3;
        //        public static final int TYPE_QUIZ = 4;
        public static final int TYPE_TEST = 4;
        public static final int TYPE_HTML = 5;
        public static final int TYPE_PDF = 6;
        // new
        public static final int TYPE_DIGNOSE = 7;
//        public static final int TYPE_FINISH = 99;

        public static final Uri getActivityUri(int id) {
            return CONTENT_URI.buildUpon().appendPath(String.valueOf(id)).build();
        }
    }

    public static final class Problems {
        public static final String _IDENTIFIER = Columns._IDENTIFIER;
        public static final String _PARENT_IDENTIFIER = "activity_identifier";
        public static final String _SEQUENCE = Columns._SEQUENCE;
        public static final String _TYPE = "problem_type";
        public static final String _BODY = Columns._BODY;
        // public static final String _WEIGHT = "weight";
        public static final String _ANALYSIS = "analysis";
//        public static final String _HAS_MEDIA = "has_media";
//        public static final String _USER_ANSWER = "user_answer";
        public static final String _USER_DURATION = Columns._USER_DURATION;
        public static final String _USER_IS_CORRECT = "user_is_correct";

        public static final Uri CONTENT_URI = AUTHORITY_URI.buildUpon().appendPath("problems").build();

        public static final int TYPE_FB = 0;
        public static final int TYPE_SA = 1;
        public static final int TYPE_MA = 2;
        public static final int TYPE_MFB = 3; // Multiple filling blanks

        public static final Uri getProblemUri(int id) {
            return CONTENT_URI.buildUpon().appendPath(String.valueOf(id)).build();
        }
    }

    public static final class ProblemChoices {
        public static final String _IDENTIFIER = Columns._IDENTIFIER;
        public static final String _PARENT_IDENTIFIER = "problem_identifier";
        public static final String _SEQUENCE = Columns._SEQUENCE;
        public static final String _CHOICE = "choice";
        public static final String _BODY = Columns._BODY;
        public static final String _ANSWER = "answer";
        public static final String _USER_CHOICE = "user_choice";

        public static final Uri CONTENT_URI = AUTHORITY_URI.buildUpon().appendPath("problem_choices").build();
    }

    public static final class Files {
        public static final String _IDENTIFIER = Columns._IDENTIFIER;
        public static final String _PARENT_IDENTIFIER = "owner_identifier";
        public static final String _PARENT_TYPE = "owner_type";
        // public static final String _SEQUENCE = "seq";
        public static final String _TYPE = "media_type";
        public static final String _KEY = "key";

        public static final int TYPE_PROBLEM = 0;
        public static final int TYPE_ACTIVITY = 1;

        public static final Uri CONTENT_URI = AUTHORITY_URI.buildUpon().appendPath("files").build();
    }

    public static final class Dialogs {
        public static final String _IDENTIFIER = Columns._IDENTIFIER;
        public static final String _TYPE = "dialog_type";
        public static final String _BODY = Columns._BODY;

        public static final Uri CONTENT_URI = AUTHORITY_URI.buildUpon().appendPath("dialogs").build();
    }
}