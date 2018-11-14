const express = require('express'),
http = require('http'),
app = express(),
server = http.createServer(app),
io = require('socket.io').listen(server);

const createGame = require('./creategame');
const manageUser = require('./manageuser');


app.get('/', (req, res) => {
res.send('Chat Server is running on port 3000')
});

manageUser.initializeUser();



io.on('connection', (socket) => {
    // User se connecte
    // On emit("connect") automatiquement



// Quand se user se connecte on l'ajoute 
socket.on('add user', function(userName) {

    console.log(userName + ' has joined ')
    // On annonce aux clients que ce User est connecté
    socket.broadcast.emit( "userjoined" , userName )

    // On ajoute ce joueur à la liste des joueurs en ligne
    manageUser.addUser(socket.id,userName);
    
})


// Quand se user se deconnecte 
// On emit("disconnect")
socket.on('disconnect', function() {
       
    console.log(' has left ')

        // On annonce aux clients que ce User est déconnecté
        socket.broadcast.emit( "userdijoined" ,' user has left')

        // On retire ce joueur à la liste des joueurs en ligne
        manageUser.deleteUser(socket.id)
    })


})


exports.createOneGame = function(idOne,idTwo) {

    io.to(`${idOne}`).emit('gamecreated', 'I just met you');
    io.to(`${idTwo}`).emit('gamecreated', 'I just met you');

}






server.listen(3000,()=>{
    console.log('Node app is running on port 3000')

    })
    