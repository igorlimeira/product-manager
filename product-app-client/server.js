const express = require('express');
const app = express();

const PORT = process.env.PORT || 8080;

app.use(express.static(__dirname + '/dist/product-app-client'));

app.get('*', (req, res) =>{
    res.sendFile(__dirname + '/dist/product-app-client/index.html');
});

app.listen(PORT, () => {
    console.log('Server started on port: ' + PORT);
});