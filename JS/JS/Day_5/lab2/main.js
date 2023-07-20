let student_warning = {
    students: [
        {
            name: "Lê Hoài Nam",
            email: "namlehoai@gmail.com",
            phone: "123456789",
            total_off: 2,
            sessions: 14,
            detail_info: [
                {
                    date: "01-09-2020",
                    note: "Xin nghỉ ốm",
                    teacher: "Bùi Hiên",
                },
                {
                    date: "05-09-2020",
                    note: "Buồn vì thất tình",
                    teacher: "Nguyễn Hàn Duy",
                },
            ],
        },
        {
            name: "Đỗ Đăng Nguyên",
            email: "nguyen@gmail.com",
            phone: "0123987654",
            total_off: 2,
            sessions: 14,
            detail_info: [
                {
                    date: "01-09-2020",
                    note: "Mưa to nên ngại đi học",
                    teacher: "Bùi Hiên",
                },
                {
                    date: "05-09-2020",
                    note: "Trượt lô, nên rút học phí để đánh",
                    teacher: "Nguyễn Hàn Duy",
                },
            ],
        },
        {
            name: "Nguyễn Xuân Ba",
            email: "3nx92nd@gmail.com",
            phone: "0344005987",
            total_off: 3,
            sessions: 14,
            detail_info: [
                {
                    date: "01-09-2020",
                    note: "Đang training không đi học được",
                    teacher: "Bùi Hiên",
                },
                {
                    date: "07-09-2020",
                    note: "Soạn giáo án đặc vụ 0175",
                    teacher: "Nguyễn Hàn Duy",
                },
                {
                    date: "10-09-2020",
                    note: "Ganks team còng lưng nên chưa đi học được",
                    teacher: "Nguyễn Hàn Duy",
                },
            ],
        },
    ],
    class: "Lập trình Game 2D Canvas",
    course: "Lập trình Game",
    sessions: 14,
    teachers: [
        {
            name: "Bùi Hiên",
            email: "hien@techmaster.vn",
            phone: "0123456789",
        },
        {
            name: "Nguyễn Hàn Duy",
            email: "duy@techmaster.vn",
            phone: "0987654321",
        },
    ],
};

// Dựa vào thông tin của object student_warning. Hãy hiển thị dự liệu tương tự như demo trong mã HTML
const classInner = document.querySelector(".class-inner");
const container = document.querySelector(".container");

const renderStudent = (studentList) => {
    studentList.students.forEach(e => {
        student += `<th>#</th>
        <th>${e.name}</th>
        <th>${e.email}</th>
        <th>${e.phone}</th>
        <th>${e.total_off}</th>
        <th>${e.date}</th>
        <th>${e.note}</th>
        <th>${e.teacher}</th>`
    });
    container.innerHTML = ` <h1>Chi tiết thông tin học viên</h1>
    <table>
        <thead>
            <tr>
                <th>#</th>
                <th>Họ tên</th>
                <th>Email</th>
                <th>Số điện thoại</th>
                <th>Số buổi nghỉ</th>
                <th>Ngày nghỉ học</th>
                <th>Ghi chú</th>
                <th>Giảng viên</th>
            </tr>
        </thead>
        <tbody>
            
            <tr>
                <td rowspan="2">1</td>
                <td rowspan="2">Nguyễn Văn A</td>
                <td rowspan="2">a@gmail.com</td>
                <td rowspan="2">0123456789</td>
                <td rowspan="2" class="text-center">2/14</td>
                <td class="text-center">22-11-2021</td>
                <td>Lý do 1</td>
                <td>Bùi Hiên</td>
            </tr>

            <tr>
                <td class="text-center">24-11-2021</td>
                <td>Lý do 2</td>
                <td>Nguyễn Hàn Duy</td>
            </tr>

            <tr>
                <td rowspan="2">2</td>
                <td rowspan="2">Trần Văn B</td>
                <td rowspan="2">b@gmail.com</td>
                <td rowspan="2">0987654321</td>
                <td rowspan="2" class="text-center">2/14</td>
                <td class="text-center">22-11-2021</td>
                <td>Lý do 1</td>
                <td>Bùi Hiên</td>
            </tr>

            <tr>
                <td class="text-center">24-11-2021</td>
                <td>Lý do 2</td>
                <td>Nguyễn Hàn Duy</td>
            </tr>

            <tr>
                <td rowspan="3">3</td>
                <td rowspan="3">Ngô Thị C</td>
                <td rowspan="3">c@gmail.com</td>
                <td rowspan="3">0988888888</td>
                <td rowspan="3" class="text-center">3/14</td>
                <td class="text-center">24-11-2021</td>
                <td>Lý do 1</td>
                <td>Bùi Hiên</td>
            </tr>

            <tr>
                <td class="text-center">26-11-2021</td>
                <td>Lý do 2</td>
                <td>Nguyễn Hàn Duy</td>
            </tr>

            <tr>
                <td class="text-center">28-11-2021</td>
                <td>Lý do 3</td>
                <td>Nguyễn Hàn Duy</td>
            </tr>
        </tbody>
    </table>`
}


const renderClass = (classInfor) => {
    let teacher ="";
    classInfor.teachers.forEach(e => {
        teacher += `<li>${e.name} ( ${e.email} - ${e.phone} )</li>`
    }); 
    classInner.innerHTML =`
    <p><span>Lớp học</span> : ${classInfor.class}</p>
                <p><span>Thuộc khóa học</span> : ${classInfor.course}</p>
                <p><span>Danh sách giảng viên</span> :</p>
                <ul>
                   ${teacher}
                </ul>
                <p></p>
                <p><span>Tổng số buổi</span> : ${classInfor.sessions}</p>
    `;

}

renderStudent(student_warning.student)
renderClass(student_warning)