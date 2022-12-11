const API_URL = '/api/account';

export async function login(username: string, password: string) {
    try {
        const response = await fetch(`${API_URL}/login`, {
            method: 'POST',
            body: JSON.stringify({ username: username, password: password }),
            headers: {
                'Content-type': 'application/json',
            },
        });
        return response;
    } catch (error) {
        throw error;
    }
}

export async function logout() {
    // localStorage.removeItem('user');
}
