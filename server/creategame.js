
const index = require('./index');


exports.checkNumberUserOnline = function(arrayUser){


   if(arrayUser.length == 2)
   {
        console.log('Il y a une game qui va pop' );

        index.createOneGame(arrayUser[0].userId,arrayUser[1].userId);
   }


}






