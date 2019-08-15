// Map Object

let map = new Map();

map.set("key", "value");

console.log(map.get("key"));

for (let [key, value] of map) {
    console.log(key + ': ' + value);
}

console.log(map.has("key")); // => true

map.delete("key");

console.log(map.has("key")); // => false

map.set("key", "value");
console.log(map.size); // => 1