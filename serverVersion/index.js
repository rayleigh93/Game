const express = require('express'),
http = require('http'),
app = express(),
server = http.createServer(app),
io = require('socket.io').listen(server);

// Modules à importer
const mongoDB= require('./mongo_db');
const manageUser = require('./manage_user');




// Initialisation à la connection BDD
 const promise = mongoDB.initMongoDB()
 .then(res =>{
    console.log("Création du SocketIO");
    // Création du SocketIO
    socketio();
 })
 .catch(err => {
    console.log(err);
 });



// Fonction qui s'occupe de toutes les fonctions provenant de SocketIO
const socketio = function(){
// User se connecte : On emit("connect") automatiquement.
io.on('connection', (socket) => {


    // Quand un user se connecte, on l'ajoute à la liste des Users 
    // et on annonce aux autres user qu'il est connecté ainsi que son nom.
    manageUser.onConnect(socket,io);
    
    
    
    // Quand le user se deconnecte 
    manageUser.onDisConnect(socket,io);
    




    
    })
    
    
}





server.listen(3000,()=>{
    console.log('Node app is running on port 3000')
    })
    