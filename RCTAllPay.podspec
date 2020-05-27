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
  s.vendored_libraries = 'ios/vendor/libAllPaySDK.a','ios/vendor/libAppleModule.a','ios/vendor/libUPModule.a'
  s.dependency 'WechatOpenSDK', '1.8.3'
  s.dependency 'AlipaySDK-iOS', '15.5.9'
  s.requires_arc = true
  s.frameworks = 'Security','CoreTelephony','SystemConfiguration'
  s.library = 'libc++','libz','libsqlite3'
end