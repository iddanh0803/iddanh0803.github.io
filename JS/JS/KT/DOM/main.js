const quizes = [
    {
        id: 1,
        question: "1 + 1 = ?",
        answers: [1, 2, 3, 4],
    },
    {
        id: 2,
        question: "2 + 2 = ?",
        answers: [2, 3, 4, 5],
    },
    {
        id: 3,
        question: "3 + 3 = ?",
        answers: [3, 4, 5, 6],
    },
];
// Lấy thẻ nút từ DOM
const randomButton = document.getElementById('btn');

// Đăng ký sự kiện click cho nút
randomButton.addEventListener('click', randomizeAnswer);

// Hàm xử lý khi nhấn vào nút "Random Answer"
function randomizeAnswer() {
    const quizItems = document.querySelectorAll('.quiz-item');

    quizItems.forEach(quizItem => {
        const radioInputs = quizItem.querySelectorAll('input[type="radio"]');
        const randomIndex = Math.floor(Math.random() * radioInputs.length);

        radioInputs.forEach((input, index) => {
            input.checked = index === randomIndex;
        });
    });
}