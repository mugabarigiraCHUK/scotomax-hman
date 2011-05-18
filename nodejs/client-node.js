/*
 * @application Message sender Node script.
 * @object Http.ClientRequest
 * @owner Scotomax
 * @create 17 May 2011
 */
var options = {
	host: '127.0.0.1',
	port: 6543,
	path: '/chat',
	method: 'POST'
};

var http = require('http');

process.stdout.write('msg> ');
process.stdin.resume();
process.stdin.setEncoding('utf8');

process.stdin.on('data', function (chunk) {
	//process.stdout.write('data: ' + chunk);	
	if ( chunk != '' ) {
		var req = http.request(options, function(res) {
				//console.log('STATUS: ' + res.statusCode);
				res.setEncoding('utf8');
				res.on('data', function (chunk) {
					//console.log('response->chunk->'+chunk);
					if (chunk != 'OK') {
						process.stdout.write('Message could not deliveryed\n');
					} else {
						process.stdout.write('Message is deliveryed\n');
					}
					process.stdout.write('msg> ');
				});				
		});
		// write data to request body
		req.write( chunk );
		req.end();
	}
});