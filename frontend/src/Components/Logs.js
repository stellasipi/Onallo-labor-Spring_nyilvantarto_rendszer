import React from 'react'

const Logs = ({logs}) =>{
    return(
        <div>
            <center><h1>Log list</h1></center>
            <div class="card">
                <div class="card-body">
                <h5 class="card-title">{logs.type}</h5>
                <h6 class="card-subtitle mb-2 text-muted">{logs.time}</h6>
                <h6 class="card-subtitle mb-2 text-muted">{logs.comment}</h6>
                {/* <p class="card-text">{logs.user.email}</p> */}
                </div>
            </div>
        </div>
    )    
};

export default Logs