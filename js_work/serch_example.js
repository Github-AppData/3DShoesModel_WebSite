const shoes = [
    {brand : 'nike', color : 'blue'},
    {brand : 'adidas', color : 'black'},
    {brand : 'FILA', color : 'white'},
];

  const serchShoes =  shoes.filter(shoes => shoes.color === 'white');
  
  console.log(serchShoes); // [ [ 'b', 2 ] ]
  
  