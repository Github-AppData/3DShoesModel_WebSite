import { GLTFLoader } from 'GLTFLoader';
import * as THREE from 'three';
import { OrbitControls } from 'OrbitControls';

$('#loading').show();

$(window).on('load', function() {
  console.log('jquery ready with resources');

  $('#loading').click(function(){
    $('#loading').hide();
    return true;
  });
});

$(document).ready(function() {
  console.log('jquery ready without resources');
});

function createScene() {
  const scene = new THREE.Scene();
  scene.background = new THREE.Color("rgb(245,245,245)");
  const light = new THREE.DirectionalLight(0xffffff, 0.8);
  scene.add(light);
  return scene;
}

function createCamera(idx) {
  const camera = new THREE.PerspectiveCamera(30, 1, 0.1, 500);
  var px = 5;
  var py = 0;
  switch (idx){
    case 0: 
      px = 0.8;
      py = 0;
      break; 
    case 1:
      px = 5;
      break;
    case 2:
      px = 1.7; 
      break;
    case 3:
      px = 0.8; 
      break;
    case 4:
      px = 0.9; 
      py = 0;
      break;
    case 5:
      px = 2.8;
      py = 0.2;
      break;
  }
  camera.position.z = px;
  camera.position.y = py;
  return camera;
}

var poy = [0,0,4.5,8.2,9.5,3.6]

function createRenderer(canvas) {
  const renderer = new THREE.WebGLRenderer({
    canvas,
    antialias: true,
  });
  renderer.outputEncoding = THREE.sRGBEncoding;
  return renderer;
}

function loadModel(scene, renderer, camera, modelPath, rotationSpeed, idx) {
  const loader = new GLTFLoader();
  loader.load(modelPath, (gltf) => {
    const model = gltf.scene;
    model.rotation.y = poy[idx];
    scene.add(model);

    function animate() {
      requestAnimationFrame(animate);
      model.rotation.y += rotationSpeed;
      renderer.render(scene, camera);
    }

    animate();

    window.addEventListener('beforeunload', () => {
      model.traverse((child) => {
        if (child instanceof THREE.Mesh) {
          child.geometry.dispose();
          child.material.dispose();
        }
      });
    });
  });
}

const canvasIds = ['canvas1', 'canvas2', 'canvas3', 'canvas4', 'canvas5', 'canvas6'];
const rotationSpeeds = [0.01, 0.01, 0.01, 0.01, 0.01, 0.01];

canvasIds.forEach((canvasId, index) => {
  const canvas = document.querySelector(`#${canvasId}`);
  const scene = createScene();
  const camera = createCamera(index);
  const renderer = createRenderer(canvas);
  loadModel(scene, renderer, camera, `3dModel/shoes${index + 1}/scene.gltf`, rotationSpeeds[index], index);
});
