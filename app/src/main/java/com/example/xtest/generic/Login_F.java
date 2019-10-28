package com.example.xtest.generic;


public class Login_F {

    public String id;
    public String login;
    public String name;
    public String surname;
    public Boolean full_name;
    public Boolean bonus_count;
    public String win_count;
    public String competitions;
    public String quiz;
    public String register_date;
    public String image;
    public Setting settings;
    public String token;
    public String success;

    public Login_F(
            String id,
            String login,
            String name,
            String surname,
            Boolean full_name,
            Boolean bonus_count,
            String win_count,
            String competitions,
            String quiz,
            String register_date,
            String image,
            Setting settings,
            String token,
            String success)
    {
        this.id = id;
        this.login = login;
        this.name = name;
        this.surname = surname;
        this.full_name = full_name;
        this.bonus_count = bonus_count;
        this.win_count = win_count;
        this.competitions = competitions;
        this.quiz = quiz;
        this.register_date = register_date;
        this.image = image;
        this.settings = settings;
        this.token = token;
        this.success = success;
    }

    public String getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Boolean getFull_name() {
        return full_name;
    }

    public Boolean getBonus_count() {
        return bonus_count;
    }

    public String getWin_count() {
        return win_count;
    }

    public String getCompetitions() {
        return competitions;
    }

    public String getQuiz() {
        return quiz;
    }

    public String getRegister_date() {
        return register_date;
    }

    public String getImage() {
        return image;
    }

    public Setting getSettings() {
        return settings;
    }

    public String getToken() {
        return token;
    }

    public String getSuccess() {
        return success;
    }
}


//"data": {
//        "id": "a595b0c6-b825-97f2-9e8e-904d1869d3dc",
//        "login": "",
//        "name": "",
//        "surname": "",
//        "full_name": "",
//        "bonus_count": "170",
//        "win_count": 1,
//        "competitions": 4,
//        "quiz": 2,
//        "register_date": "2018-12-20 20:27:28.000000 +0300",
//        "image": "http://dev.hakta.pro/o/silkway/uploads/files/user_no_avatar-min.jpg",
//        "settings": {
//        "language": "ru",
//        "push_news": true,
//        "push_competition": false,
//        "push_competition_result": false
//        },
//        "token": "2796e244-dad8-75a3-a718-7e48d8959c1a"
//        },
//        "success": true