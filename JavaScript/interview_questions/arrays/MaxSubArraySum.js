function maxSubArraySum(array) {
  let size = array.length;
  let max = -Infinity;
  let temp = 0;

  for (let i = 0; i < size; i++) {
    temp = temp + array[i];
    if (max < temp) {
      max = temp;
    }

    if (temp < 0) {
      temp = 0;
    }
  }
  return max;
}
