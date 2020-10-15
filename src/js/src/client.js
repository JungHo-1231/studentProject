import fetch from 'unfetch';

const checkStatus = (response) => {
	if (response.ok) {
		return response;
	} else {
		let error = new Error(response.statusText);
		error.response = response;
		response.json().then((e) => {
			error.error = e;
		});
		return Promise.reject(error);
	}
};

export const getAllStudents = () =>
	fetch('api/students').then(checkStatus);

export const addNewStudent = (stduent) =>
	fetch('api/students', {
		headers : {
			'Content-Type' : 'application/json'
		},

		method  : 'POST',
		body    : JSON.stringify(stduent)
	}).then(checkStatus);
