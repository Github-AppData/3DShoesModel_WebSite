window.addEventListener('load', function() {
            var allElements = document.getElementsByTagName('*');
            Array.prototype.forEach.call(allElements, function(el) {
                var includePath = el.dataset.includePath;
                if (includePath) {
                    var xhttp = new XMLHttpRequest();
                    xhttp.onreadystatechange = function () {
                        if (this.readyState == 4 && this.status == 200) {
                            el.outerHTML = this.responseText;
                        }
                    };
                    xhttp.open('GET', includePath, true);
                    xhttp.send();
                }
            });
        });
        
function replaceWith3DModel(uid, iframeId) {
        var iframe = document.getElementById(iframeId);
        var client = new Sketchfab(iframe);

        client.init(uid, {
            success: function onSuccess(api) {
                api.start();
                api.addEventListener('viewerready', function() {
                    console.log(iframeId + ' 3D 모델이 준비되었습니다.');
                });
            },
            error: function onError() {
                console.log(iframeId + ' 3D 모델 초기화 오류');
            }
        });
    }
    
var imageToModelMapping = [
        { uid: 'b404398cf8ab4773b4b15230a2f7c292', iframeId: 'api-frame-1' },
        { uid: 'faef9fe5ace445e7b2989d1c1ece361c', iframeId: 'api-frame-2' },
        { uid: 'c00345fd64414c4e8895c6aaa262e4d5', iframeId: 'api-frame-3' }
        
    ];

    // 이미지를 3D 모델로 대체
    imageToModelMapping.forEach(function(mapping) {
        replaceWith3DModel(mapping.uid, mapping.iframeId);
    });