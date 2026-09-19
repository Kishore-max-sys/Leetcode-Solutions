/**
 * @param {Array} arr1
 * @param {Array} arr2
 * @return {Array}
 */
var join = function(arr1, arr2) {
    let map=new Map();
    const arr=new Array();
    for(let i=0;i<arr1.length;i++){
        arr.push(arr1[i]);
        map.set(arr1[i].id,i);
    }
    for(let i=0;i<arr2.length;i++){
        if(map.has(arr2[i].id)){
            const ind=map.get(arr2[i].id);
            arr[ind]={...arr[ind],...arr2[i]};
        }else{
            arr.push(arr2[i]);
        }
    }
    arr.sort((a,b) =>{
        if(a.id>b.id) return 1;
        return -1;
    });
    return arr;
};