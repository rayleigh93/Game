



exports.createJsonGameObject = function(idPlayerOne,idPlayerTwo,idGame) {

    var gameObject = 

        {"arrayCase":
            [{"typeCase":"vide"},
             {"typeCase":"vide"},
             {"typeCase":"green"}
            ,{"typeCase":"vide"},
              {"typeCase":"vide"},
                 {"typeCase":"red"},
                 {"typeCase":"vide"},
              {"typeCase":"vide"},
                 {"typeCase":"red"}],

        "idUserTwo":idPlayerTwo,
        "idUserOne":idPlayerOne,
        "playerTurn":idPlayerOne}

        return gameObject;
}
