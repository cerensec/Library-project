import { User } from '../interfaces';

const API_URL = '/api/account';

export async function login(username: string, password: string): Promise<User> {
    // const response = await fetch(`${API_URL}/login`, {
    //     method: 'POST',
    //     body: JSON.stringify({ username: username, password: password }),
    //     headers: {
    //         'Content-type': 'application/json',
    //     },
    // });
    // console.log(response);
    // if (response.ok) {
    //     return response.json();
    // } else {
    //     throw await response.json();
    // }
    const response = await fetch(`${API_URL}/login`, {
        method: 'POST',
        body: JSON.stringify({ username: username, password: password }),
        headers: {
            'Content-type': 'application/json',
        },
    });
    try {
        return response.json();
    } catch (e) {
        throw await response.json();
    }
}

export async function logout() {
    // localStorage.removeItem('user');
}
