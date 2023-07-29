// Bài 1:
const inputStrings = ['aba', 'aa', 'ad', 'c', 'vcd']
function getStringHasMaxLength(strings) {
    let maxLength = 0;
    let longestStrings = [];
    for (let i = 0; i < strings.length; i++) {
        const currentLength = strings[i].length;
        if (currentLength > maxLength) {
            maxLength = currentLength;
        }
    }
    for (let i = 0; i < strings.length; i++) {
        if (strings[i].length === maxLength) {
            longestStrings.push(strings[i]);
        }
    }

    return longestStrings;
}
console.log(getStringHasMaxLength(inputStrings))

// Bài 2
const users = [
    {
        name: "Bùi Công Sơn",
        age: 30,
        isStatus: true
    },
    {
        name: "Nguyễn Thu Hằng",
        age: 27,
        isStatus: false
    },
    {
        name: "Phạm Văn Dũng",
        age: 20,
        isStatus: false
    }
]

function getUsersWithAgeAndStatus(users) {
    return users.filter(user => user.age > 25 && user.isStatus === true);
}
console.log(getUsersWithAgeAndStatus(users))

function getUsersSortedByAge(users) {
    return users.sort((a, b) => a.age - b.age);
}
console.log(getUsersSortedByAge(users))

// Bài 3
const arr = ["one", "two", "three", "one", "one", "three"]

function getCountElement(arr) {
    const countObject = {};

    for (let i = 0; i < arr.length; i++) {
        const element = arr[i];
        if (countObject[element]) {
            countObject[element] += 1;
        } else {
            countObject[element] = 1;
        }
    }

    return countObject;
}
console.log(getCountElement(arr))