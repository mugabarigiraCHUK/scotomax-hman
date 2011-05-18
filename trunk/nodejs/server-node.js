/*
 * @application Message receiver Node script.
 * @object Http.ServerListener
 * @owner Scotomax
 * @create 17 May 2011
 */
var http = require('http');

http.createServer(function (req, resp) {
	//console.log('req->method->'+req.method);
	// Http.ServerRequest Event 'data'  
	req.on ('data', function(chunk){
		process.stdout.write('income msg> '+chunk);
	});
	// Response back
	resp.writeHead(200, {'Content-Type': 'text/plain'});
	resp.end('OK');
}).listen(6543);

console.log('Message Receiver running at http://127.0.0.1:6543/');