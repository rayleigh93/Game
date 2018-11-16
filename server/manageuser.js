
exports.userArray ;
const createGame = require('./creategame');



exports.initializeUser = function() {
    userArray = new Array();
}


exports.addUser = function(id,userName){
var newUser = {userId: id, userName: userName };
userArray.push(newUser);
console.log(newUser);
        numberOnline();


        createGame.checkNumberUserOnline(userArray);


}


exports.deleteUser = function(id) {

    userArray.forEach(function (element,i) {
        if(element.userId === id)
        userArray.splice(i,1);
        // Remove 1 item à l'index 'element'
    });
        numberOnline();

}

exports.sendArray = function(){
    return userArray;
}





  function numberOnline() {
    console.log('Il y actuellement : ' + userArray.length + ' user(s) sur le serveur') ;
}