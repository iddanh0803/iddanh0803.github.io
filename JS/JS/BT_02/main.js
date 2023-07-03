const grades = [
    {name: 'John', grade: 8, sex: 'M'},
    {name: 'Sarah', grade: 12, sex: 'F'},
    {name: 'Bob', grade: 16, sex: 'M'},
    {name: 'Johnny', grade: 2, sex: 'M'},
    {name: 'Ethan', grade: 4, sex: 'M'},
    {name: 'Paula', grade: 18, sex: 'F'},
    {name: 'Donald', grade: 5, sex: 'M'},
    {name: 'Jennifer', grade: 13, sex: 'F'},
    {name: 'Courtney', grade: 15, sex: 'F'},
    {name: 'Jane', grade: 9, sex: 'F'}
   ]
   console.log(grades)
// Viết function tính thứ hạng trung bình của cả lớp
function averageGrade(grades) {
    let sum = 0;
    grades.forEach((student) => {
      sum += student.grade;
    });
    return sum / grades.length;
}
console.log(averageGrade(grades))
// Viết function tính thứ hạng trung bình của nam trong lớp
function averageGradeMale(grades) {
    let sum = 0;
    let count = 0;
    grades.forEach((student) => {
      if (student.sex === 'M') {
        sum += student.grade;
        count++;
      }
    });
    return sum / count;
}
console.log(averageGradeMale(grades))
//Viết function tính thứ hạng trung bình của Nữ trong lớp
function averageGradeFemale(grades) {
    let sum = 0;
    let count = 0;
    grades.forEach((student) => {
      if (student.sex === 'F') {
        sum += student.grade;
        count++;
      }
    });
    return sum / count;
}
console.log(averageGradeFemale(grades))
//Viết function tìm học viên Nam có thứ hạng cao nhất trong lớp
function highestGradeMale(grades) {
    let highestGrade = 0;
    let highestGradeMale = null;
    grades.forEach((student) => {
      if (student.sex === 'M' && student.grade > highestGrade) {
        highestGrade = student.grade;
        highestGradeMale = student;
      }
    });
    return highestGradeMale;
}
console.log(highestGradeMale(grades))
//Viết function tìm học viên Nữ có thứ hạng cao nhất trong lớp
function highestGradeFemale(grades) {
    let highestGrade = 0;
    let highestGradeFemale = null;
    grades.forEach((student) => {
      if (student.sex === 'F' && student.grade > highestGrade) {
        highestGrade = student.grade;
        highestGradeFemale = student;
      }
    });
    return highestGradeFemale;
}
console.log(highestGradeFemale(grades))
//Viết function tìm học viên Nam có thứ hạng thấp nhất trong lớp
function lowestGradeMale(grades) {
    let lowestGrade = Infinity;
    let lowestGradeMale = null;
    grades.forEach((student) => {
      if (student.sex === 'M' && student.grade < lowestGrade) {
        lowestGrade = student.grade;
        lowestGradeMale = student;
      }
    });
    return lowestGradeMale;
}
console.log(lowestGradeMale(grades))
//Viết function tìm học viên Nữ có thứ hạng thấp nhất trong lớp
function lowestGradeFemale(grades) {
    let lowestGrade = Infinity;
    let lowestGradeFemale = null;
    grades.forEach((student) => {
      if (student.sex === 'F' && student.grade < lowestGrade) {
        lowestGrade = student.grade;
        lowestGradeFemale = student;
      }
    });
    return lowestGradeFemale;
}
console.log(lowestGradeFemale(grades))
//Viết function thứ hạng cao nhất của cả lớp
function highestGrade(grades) {
    let highestGrade = 0;
    grades.forEach((student) => {
      if (student.grade > highestGrade) {
        highestGrade = student.grade;
      }
    });
    return highestGrade;
}
console.log(highestGrade(grades))
//Viết function thứ hạng thấp nhất của cả lớp
function lowestGrade(grades) {
    let lowestGrade = Infinity;
    grades.forEach((student) => {
      if (student.grade < lowestGrade) {
        lowestGrade = student.grade;
      }
    });
    return lowestGrade;
}
console.log(lowestGrade(grades))
//Viết function lấy ra danh sách tất cả học viên Nữ trong lớp
function getAllFemaleStudents(grades) {
    let females = [];
    grades.forEach((student) => {
      if (student.sex === 'F') {
        females.push(student);
      }
    });
    return females;
}
console.log(getAllFemaleStudents(grades))
//Viết function sắp xếp tên học viên theo chiều tăng dần của bảng chữ cái
function sortStudentByName(grades) {
    return grades.sort((a, b) => a.name.localeCompare(b.name));
  }
console.log(sortStudentByName(grades))
//Viết function sắp xếp thứ hạng học viên theo chiều giảm dần
function sortStudentByGrade(grades) {
    return grades.sort((a, b) => b.grade - a.grade);
}
console.log(sortStudentByGrade(grades))
//Viết function lấy ra học viên Nữ có tên bắt đầu bằng “J”
function getFemaleStudentsWithNameStartingWithJ(grades) {
    let femalesWithJ = [];
    grades.forEach((student) => {
      if (student.sex === 'F' && student.name.charAt(0) === 'J') {
        femalesWithJ.push(student);
      }
    });
    return femalesWithJ;
}
console.log(getFemaleStudentsWithNameStartingWithJ(grades))
//Viết function lấy ra top 5 người có thứ hạng cao nhất trong lớp
function getTop5Students(grades) {
    let sortedGrades = sortStudentByGrade(grades);
    return sortedGrades.slice(0, 5);
}
console.log(getAllFemaleStudents(grades))

  