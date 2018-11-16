const express = require('express'),
http = require('http'),
app = express(),
server = http.createServer(app),
io = require('socket.io').listen(server);

const createGame = require('./creategame');
const manageUserModule = require('./manageuser');
const gameObject = require('./gameobject');


app.get('/', (req, res) => {
res.send('Chat Server is running on port 3000')
});

manageUserModule.initializeUser();



io.on('connection', (socket) => {
    // User se connecte
    // On emit("connect") automatiquement



// Quand se user se connecte on l'ajoute 
socket.on('add user', function(userName) {

    console.log(userName + ' has joined ')
    // On annonce aux clients que ce User est connecté
    socket.broadcast.emit( "userjoined" , userName )

    // On ajoute ce joueur à la liste des joueurs en ligne
    manageUserModule.addUser(socket.id,userName);
    
})


// Quand se user se deconnecte 
// On emit("disconnect")
socket.on('disconnect', function() {
       
    console.log(' has left ')

        // On annonce aux clients que ce User est déconnecté
        socket.broadcast.emit( "userdijoined" ,' user has left')

        // On retire ce joueur à la liste des joueurs en ligne
        manageUserModule.deleteUser(socket.id)
    })


    socket.on('sendaction', function(position) {
       
         console.log(' action ' + position)
         sendGame(position,socket.id)
    
        })



})


function sendGame(position,userIdPlayed) {

    var array = manageUserModule.sendArray();
    
  

    io.to(`${array[0].userId}`).emit('playerplay',  gameObject.changeGameObjects(position,userIdPlayed) );
    io.to(`${array[1].userId}`).emit('playerplay',   gameObject.changeGameObjects(position,userIdPlayed));

}




exports.createOneGame = function(idOne,idTwo) {

    var game = gameObject.createJsonGameObject(idOne,idTwo,"AZERTY");

    io.to(`${idOne}`).emit('gamecreated', game);
    io.to(`${idTwo}`).emit('gamecreated', game);

}






server.listen(3000,()=>{
    console.log('Node app is running on port 3000')

    })
    