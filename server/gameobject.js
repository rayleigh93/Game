
exports.gameObject ;
const manageUserModule = require('./manageuser');

exports.createJsonGameObject = function(idPlayerOne,idPlayerTwo,idGame) {

    var gameObjectStart = 

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

        gameObject = gameObjectStart;
        return gameObjectStart;
}


exports.changeGameObjects = function(position,idUserPlayed){


    if(idUserPlayed === gameObject.idUserOne)
    gameObject.playerTurn = gameObject.idUserTwo
    else
    gameObject.playerTurn = gameObject.idUserOne


    gameObject.arrayCase[position].typeCase = "green";


    console.log(gameObject);


    return gameObject;

}