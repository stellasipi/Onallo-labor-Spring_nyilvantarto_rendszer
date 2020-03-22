import React from 'react'

const Logs = ({logs}) => {
    return (
        <div>
            <center><h1>Log List</h1></center>
            {logs.map((log) => (
                <div class="card">
                    <div class="card-body">
                        <h5 class="card-title">{log.type}</h5>
                        <h6 class="card-subtitle mb-2 text-muted">{log.time}</h6>
                        <h6 class="card-subtitle mb-2 text-muted">{log.comment}</h6>
                        <p class="card-text">{log.user.name}</p>
                    </div>
                </div>
            ))}
        </div>
    )
};

export default Logs