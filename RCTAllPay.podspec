require "json"

package = JSON.parse(File.read(File.join(__dir__, "package.json")))

Pod::Spec.new do |s|
  s.name         = "RCTAllPay"
  s.version      = package["version"]
  s.summary      = package["description"]
  s.homepage     = package["repository"]["url"]
  s.license      = package["license"]
  s.author       = package["author"]
  s.platforms    = { :ios => "9.0" }
  s.source       = { :git => package["repository"]["url"], :tag => "#{s.version}" }
  s.source_files = "ios/**/*.{h,m}"
  s.dependency "React"
  s.vendored_libraries = 'ios/RCTAllPay/vendor/libAllPaySDK.a', 'ios/RCTAllPay/vendor/libAppleModule.a', 'ios/RCTAllPay/vendor/libUPModule.a'
  
  s.requires_arc = true
  s.frameworks = 'Security', 'CoreTelephony', 'SystemConfiguration'
  s.library = 'c++','z','sqlite3'
end
