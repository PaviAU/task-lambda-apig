exports.handler = async (event) => {
    // Your Lambda function logic here
    const firstName = event.queryStringParameters?.first_name || 'John';
    const lastName = event.queryStringParameters?.last_name || 'Doe';
    
    const response = {
        statusCode: 200,
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify({ first_name: firstName, last_name: lastName }),
       /*  body: JSON.stringify({
            message: "Hello from Lambda!"
            // Add more data as needed

        }) */
    };

    return response;
};