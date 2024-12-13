import marvel.champions.UserPasswordEncoderListener
import org.springframework.mail.javamail.JavaMailSenderImpl

// Place your Spring DSL code here
beans = {
    userPasswordEncoderListener(UserPasswordEncoderListener)
    mailSender(JavaMailSenderImpl) {
        host = 'smtp.mailtrap.io'
        port = 2525
        username = '0b6a07921626b7'
        password = 'eee588d148baa1'
        javaMailProperties = {
            def props = new Properties()
            props.put('mail.smtp.auth', 'true')
            props.put('mail.smtp.starttls.enable', 'true')
            props
        }()
    }
}
