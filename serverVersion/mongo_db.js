// Ce fichier s'occupe de modéliser toutes les intéractions entre la bdd et le serveur

const nameBdd = "game";

const mongoose = require('mongoose');
const mongoModel = require('./mongo_model');



// Initialisation de la connection à la base de donnée et 
// suppression de la collection de la liste des User Online
exports.initMongoDB = function() {

    return new Promise(function (res,rej){
        //Initialisation de la connection de la BDD mongoDB
        mongoose.connect('mongodb://localhost/game', function(err){
        if(err) {
                    console.error.bind(console, 'connection error:')
                    rej(err);
                }

        else {
            console.log("Connection à mongoDB : OK")

            //Suppression de la collection de la liste des User Online
            mongoose.connection.db.dropCollection(mongoModel.CollectionUserOnlineString, function(err, result) {
                console.log("Delete collection : joueurs en lignes");
                res(result);
            });


             }
    })
});
}



// Ajoute un user à la liste des User Online
exports.addUserToDB = function(username,id) {
    var newUser = new mongoModel.UserOnlineModel({userName:username,id:id});
  
    newUser.save(function(err,user){
        if (err) return console.error(err);
    })
}


// Delete un user à la liste des User Online
exports.deleteUserToDB = function(idUser) {

    mongoModel.UserOnlineModel.findOne({id: idUser},function(err,user){

        if (err) {
            return console.error(err);
        }

        else {
            // delete l'user qui se déconnecte
            console.log(user.userName + " disconnected")
            user.remove(function(err){
                if (err) {  
                    return console.error(err);
                         }
                else {  
                    console.log("DELETE USER")}
                                     });
            }
      
    })


}






