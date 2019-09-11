'use strict';
const nodemailer = require('nodemailer');

async function sendFeedBackMail(subject, toEmail, htmlBody) {
    // create reusable transporter object using the default SMTP transport
    let transporter = nodemailer.createTransport({
        host: 'smtp.gmail.com',
        port: 465,
        secure: true, // true for 465, false for other ports
        auth: {
            user: 'gupta.neha346@gmail.com', // generated ethereal user
            pass:  'nehagupta346'// generated ethereal password
        }
    });
    
    // send mail with defined transport object
    var sendMail = function(toEmail,subject,htmlBody){
        let info = transporter.sendMail({
            from: 'gupta.neha346@gmail.com', // sender address
            to: toEmail, // list of receivers
            subject: subject, // Subject line
            html: htmlBody // html body
        });
    
        console.log('Message sent: %s', info.messageId);
        console.log('Preview URL: %s', nodemailer.getTestMessageUrl(info));
    };

    sendMail(subject, toEmail, htmlBody);
}

sendFeedBackMail("gupta.neha346@gmail.com","Node-Js.........1","hello.......").catch(console.error);
exports.sendFeedBackMail = sendFeedBackMail;
