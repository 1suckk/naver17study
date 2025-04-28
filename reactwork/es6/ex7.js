let array=['red','green','blue','pink'];
array.map((num, idx)=>(console.log(idx+":"+num)));
console.log("\n");
//2번 인덱스만 제외하고 다시 배열에 담기
array=[...array.slice(0,2),
    ...array.slice(3,array.length)];
array.map((num,idx)=>(console.log(idx+":"+num)));

let array2=['red','green','blue','pink'];
console.log("\n");
array2.map((num,idx)=>(console.log(idx+":"+num)));
//2번만 제외하고 배열에 담기
console.log("\n");
array2=array2.filter((item,i)=>1!=2);
array2.map((num,idx)=>(console.log(idx+":"+num)));

console.log(Number('01'));