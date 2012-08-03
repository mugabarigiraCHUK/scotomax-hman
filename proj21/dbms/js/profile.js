// Javascript for only using by profile.php
// ++++++++++++++++++++++++++++++++++++++++++

!function ($) {

  // On-load
  $(function(){
  	// variables
  	var vfile;
  	var inputFile = document.getElementById("file");
  	var dropZone = document.getElementById("drop_zone");
  	var cmdUpdate = document.getElementById("cmdupload");

	/*
	 * JS function for update raw image by XMLHttpRequest().
	 * @param file
	 */
	var submitFile = function() {
		if ( vfile == "undefined" || vfile == "" ) {
			alert("System could not source file for uploading.");
		} else {
			// Attributes
			var progressBar = $("#progress"), 
				formData = new FormData(), 
				xhr = new XMLHttpRequest();

			// Uploading - for Firefox, Google Chrome and Safari
			formData.append('file', vfile);

			// Define HTTP POST to server
			xhr.open("POST", "controller/profile_img.php", true);
			
			// Event handle after HTTP server response
			xhr.onload = function(e) {
				if (this.status == 200) {
					var resp = this.responseText;
					console.log(resp);
					//window.location.reload();
				}
			}

			// Update progress bar
			xhr.upload.addEventListener("progress", function (evt) {
				if (evt.lengthComputable) {
					//progressBar.style.width = (evt.loaded / evt.total) * 100 + "%";
					progressBar.css('width', (evt.loaded / evt.total) * 100 + '%');
				}
			}, false);
			// Send the file (doh)
			xhr.send(formData);
		}
	};

	/*
	 * JS function for prevent drag over event
	 * @param event
	 */
	var handleDragOver = function(evt) {
		evt.stopPropagation();
		evt.preventDefault();
		evt.dataTransfer.dropEffect = 'copy'; // Explicitly show this is a copy.
	};
		
	/*
	 * JS function for handle file event.
	 * @param event
	 */
	var handleFileSelect = function(evt) {
		console.log("Handle file selection event...");
		// Break JS event
		evt.stopPropagation();
		evt.preventDefault();

		var files;
		// choose files
		if (evt.target.files != undefined) {
			files = evt.target.files;
		} else { 
		// drag drop files
			files = evt.dataTransfer.files;
		}

		file = files[0];
		/*
			If the file is an image and the web browser supports FileReader,
			present a preview in the file list
		*/
		if ( typeof FileReader !== "undefined" ) {
			if ( (/image/i).test(file.type) && file.type.match('image.*') ) {
				// JS File reader
				var reader = new FileReader();
				reader.onload = (function (theFile) {
					return function (evt) {
						// Clear existing displayed image
						$("#listUploadImage").empty();
						// Create new image panel
						var span = document.createElement('span');
						span.innerHTML = ['<img class="thumbSmall"', 
								            , ' file=', theFile, ''
								            , ' title="', theFile.name, ' - ', evt, '"'
								            , ' src="', evt.target.result, '"/>']
								            .join('');
						// insert image pable HTML into right place
						listUploadImage.insertBefore(span, null);
					};
				}(file));
				// JS reader on error handle
				reader.onerror = function(evt) {
					alert("File reader has failed");
				}
				// JS reader local file by URL
				reader.readAsDataURL(file);
				// Store local file.
				vfile = file;
			} else {
				alert("Source file is not kind of image.");
			}
		} else {
			alert("Browser doesn't support this feature");
		}
	};

	inputFile.addEventListener('change', handleFileSelect, false);
	dropZone.addEventListener('dragover', handleDragOver, false);
	dropZone.addEventListener('drop', handleFileSelect, false);
	cmdUpdate.addEventListener('click', submitFile, false);

  })

}(window.jQuery)