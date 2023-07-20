// Get the todo list element
const todoList = document.getElementById("todo-list");

// Get the add todo form element
const addTodoForm = document.getElementById("add-todo-form");

let todos = [
	{ id: 1, title: "Đi chơi", completed: false },
	{ id: 2, title: "Học bài", completed: true },
	{ id: 3, title: "Đá bóng", completed: false }
];

// Display the initial todo list
displayTodos();

// Add submit event listener to the add todo form
addTodoForm.addEventListener("submit", function (event) {
	// Prevent the default form submission behavior
	event.preventDefault();

	// Get the todo title input element
	const todoTitleInput = document.getElementById("todo-title");

	// Get the todo title value
	const todoTitle = todoTitleInput.value.trim();

	// If the todo title is empty, show an alert
	if (!todoTitle) {
		alert("Todo title cannot be empty!");
		return;
	}

	// Add the new todo to the list
	const newTodo = { id: getNextTodoId(), title: todoTitle, completed: false };
	todos.push(newTodo);

	// Clear the todo title input element
	todoTitleInput.value = "";

	// Display the updated todo list
	displayTodos();
});

// Function to display the todo list
function displayTodos() {
	// Clear the todo list element
	todoList.innerHTML = "";

	// If there are no todos, display a message
	if (todos.length === 0) {
		const message = document.createElement("p");
		message.textContent = "Todo list is empty.";
		todoList.appendChild(message);
		return;
	}

	// Loop through the todos and create li elements for each one
	for (const todo of todos) {
		// Create the li element
		const li = document.createElement("li");

		// Add the completed class if the todo is completed
		if (todo.completed) {
			li.classList.add("completed");
		}

		// Create the checkbox element
		const checkbox = document.createElement("input");
		checkbox.type = "checkbox";
		checkbox.checked = todo.completed;
		checkbox.addEventListener("change", function () {
			todo.completed = !todo.completed;
			if (todo.completed) {
				li.classList.add("completed");
			} else {
				li.classList.remove("completed");
			}
		});
		li.appendChild(checkbox);

		// Create the todo title element
		const title = document.createElement("span");
		title.textContent = todo.title;
		li.appendChild(title);

		// Create the buttons container
		const buttonsContainer = document.createElement("div");
		buttonsContainer.classList.add("buttons");

		// Add the edit button
		const editButton = document.createElement("button");
		editButton.textContent = "Edit";
		editButton.addEventListener("click", function () {
			const newTitle = prompt("Enter a new title:", todo.title);
			if (newTitle && newTitle.trim() !== "") {
				todo.title = newTitle.trim();
				displayTodos();
			}
		});
		buttonsContainer.appendChild(editButton);

		// Add the delete button
		const deleteButton = document.createElement("button");
		deleteButton.textContent = "Delete";
		deleteButton.addEventListener("click", function () {
			const confirmDelete = window.confirm("Are you sure you want to delete this todo?");
			if (confirmDelete) {
				todos = todos.filter(function (t) {
					return t.id !== todo.id;
				});
				displayTodos();
			}
		});
		buttonsContainer.appendChild(deleteButton);

		// Add the buttons container to the li element
		li.appendChild(buttonsContainer);

		// Add the li element to the todo list element
		todoList.appendChild(li);
	}
}

