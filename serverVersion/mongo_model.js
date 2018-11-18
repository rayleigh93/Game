// Ce fichier s'occupe d'organiser les 'MONGO DB MODEL'
const mongoose = require('mongoose');



// NOM DES COLLECTIONS
const CollectionUserOnline = "userOnline"
exports.CollectionUserOnlineString = CollectionUserOnline;





// UserOnline (User ajouté à la liste des User actuellement en ligne)
var userOnlineSchema = new mongoose.Schema({
    userName: String,
    id: String
},{ collection: CollectionUserOnline});

var UserOnlineModel = mongoose.model('useronline',userOnlineSchema);
exports.UserOnlineModel = UserOnlineModel;



