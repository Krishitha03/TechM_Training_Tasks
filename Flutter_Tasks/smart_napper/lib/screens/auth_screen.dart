import 'package:flutter/material.dart';
import 'package:firebase_auth/firebase_auth.dart';

class AuthScreen extends StatefulWidget {
  @override
  _AuthScreenState createState() => _AuthScreenState();
}

class _AuthScreenState extends State<AuthScreen> {
  final FirebaseAuth _auth = FirebaseAuth.instance;
  bool isLogin = true;
  final _formKey = GlobalKey<FormState>();
  String email = "";
  String password = "";
  String errorMessage = "";

  void _submitForm() async {
    final isValid = _formKey.currentState?.validate();
    if (!isValid!) return;
    
    _formKey.currentState?.save();
    try {
      if (isLogin) {
        await _auth.signInWithEmailAndPassword(email: email, password: password);
      } else {
        await _auth.createUserWithEmailAndPassword(email: email, password: password);
      }
    } catch (error) {
      setState(() {
        errorMessage = error.toString();
      });
    }
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: Container(
        decoration: BoxDecoration(
          gradient: LinearGradient(colors: [Colors.blueGrey, Colors.black], begin: Alignment.topCenter, end: Alignment.bottomCenter),
        ),
        child: Center(
          child: Card(
            margin: EdgeInsets.all(20),
            color: Colors.black.withOpacity(0.7),
            shape: RoundedRectangleBorder(borderRadius: BorderRadius.circular(15)),
            child: Padding(
              padding: EdgeInsets.all(16),
              child: Form(
                key: _formKey,
                child: Column(
                  mainAxisSize: MainAxisSize.min,
                  children: [
                    Text(isLogin ? "Login" : "Sign Up", style: TextStyle(fontSize: 24, fontWeight: FontWeight.bold, color: Colors.white)),
                    SizedBox(height: 10),
                    TextFormField(
                      decoration: InputDecoration(labelText: "Email", prefixIcon: Icon(Icons.email), filled: true, fillColor: Colors.white.withOpacity(0.2)),
                      keyboardType: TextInputType.emailAddress,
                      validator: (value) => value!.isEmpty || !value.contains('@') ? "Enter a valid email" : null,
                      onSaved: (value) => email = value!,
                    ),
                    SizedBox(height: 10),
                    TextFormField(
                      decoration: InputDecoration(labelText: "Password", prefixIcon: Icon(Icons.lock), filled: true, fillColor: Colors.white.withOpacity(0.2)),
                      obscureText: true,
                      validator: (value) => value!.length < 6 ? "Password must be at least 6 characters" : null,
                      onSaved: (value) => password = value!,
                    ),
                    if (errorMessage.isNotEmpty) Padding(padding: EdgeInsets.all(8), child: Text(errorMessage, style: TextStyle(color: Colors.red))),
                    SizedBox(height: 10),
                    ElevatedButton(
                      style: ElevatedButton.styleFrom(backgroundColor: Colors.blue),
                      onPressed: _submitForm,
                      child: Text(isLogin ? "Login" : "Sign Up"),
                    ),
                    TextButton(
                      onPressed: () => setState(() => isLogin = !isLogin),
                      child: Text(isLogin ? "Create an account" : "Already have an account? Login", style: TextStyle(color: Colors.white)),
                    ),
                  ],
                ),
              ),
            ),
          ),
        ),
      ),
    );
  }
}
